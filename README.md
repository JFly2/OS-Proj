# CS451/CS650 Operating Systems Simulator

This repository contains a sequence of projects developed for **CS451/CS650: Design of Operating Systems**. The goal of these projects is to simulate key components of an operating system — including process management, CPU scheduling, and memory management — using either **Java** or **C**.

---

## Project Overview

### Project 1: Process Table and OS Skeleton
- Implemented a basic OS skeleton featuring a `PCB` (Process Control Block) class.
- Each `PCB` holds:
  - Parent Process ID (ppid)
  - Process State (`'n'` for "new")
  - Process Name
  - Priority
  - Arrival Time
  - CPU Burst Time
  - Register Set values (`XAR`, `XDI`, ..., `R7`)
  - Pointer to the next PCB
- Simulated reading from `processes1.txt` to populate a `ProcessTable` (array of 100 PCBs).
- The main loop iterates through the simulated clock and inserts new processes into the Process Table as their arrival times match the current clock cycle.
- Each new PCB's `ppid` and `nextPCB` are initialized to link logically to the previous process.

---

### Project 2: CPU Scheduling (First Come First Serve)
- Extended the system to simulate **FCFS (First-Come, First-Served)** CPU scheduling.
- Classes:
  - `RegisterSet`: Holds CPU register values.
  - `PCB`: Updated to include process status (`'r'`, `'e'`, `'t'`), burst time, and more.
  - `OS`: Simulation driver.
- Data Structures:
  - `Process_Table`: Fixed-size array of 50 PCBs.
  - `ReadyQ`: FIFO queue for processes, implemented using `nextPCB` fields and two pointers: `ReadyQFront` and `ReadyQRear`.
  - `TerminatedQ`: Holds the PID of the most recently terminated process.
  - `CPU`: Stores PID of the currently running process.
- File I/O is replaced by a pre-loaded array of input lines (from `processes2.txt`) to improve efficiency.

---

### Project 4: Memory Management with Variable Partition Allocation
- Introduced dynamic memory management into the simulator.
- PCB now includes:
  - `start_loc`: Start location in memory for the process
  - `process_size`: Memory required for code/data
- A new input format (`processes4.txt`) includes process size along with prior fields.
- New Queues:
  - `MemoryWaitingQ`: Holds processes that are ready but cannot yet be allocated memory.
  - `Free_Partitions`: A linked list of free memory partitions (start location, size, next node).
- Implemented:
  - `Allocate()` method to assign memory using variable partition strategy.
  - `Deallocate()` method to free memory after process termination and update the free partition list.
- Simulation tracks how limited memory resources impact scheduling and performance.

---

## File Inputs

Each input file (e.g., `processes1.txt`, `processes2.txt`, `processes4.txt`) contains one line per process. Format includes:
1. Process Name
2. Priority
3. Arrival Time
4. CPU Burst Time
5. Process Size (Project 4 only)
6. Register Set values (`XAR`, `XDI`, `XDO`, `PC`, `IR`, `EMIT`, `RR`, `PSW`, `R0-R7`)

---

## Key Concepts Covered

- Process Table Design
- PCB Construction and Linking
- Queue Management using Linked Indices
- CPU Scheduling Algorithms (FCFS)
- Memory Partitioning and Allocation
- Resource Reclamation on Termination

---

## How to Run

1. Compile and run using Java or C (depending on your implementation).
2. Provide the correct input file (`processesX.txt`) at runtime.
3. Observe the system simulation via printed logs or state tables.

---

## Suggestions for Future Extensions

- Add Round Robin or Priority Scheduling
- Track CPU utilization and throughput
- Implement paging or segmentation
- Simulate I/O operations and interrupts

---

## Author

Developed as part of CS451/CS650 coursework to gain hands-on experience with Operating System concepts.

