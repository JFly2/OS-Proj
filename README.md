
---

# Project Overview

## Project 1: Process Table and OS Skeleton

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

## Project 2: CPU Scheduling (First Come First Serve)

Extended the system to simulate **First-Come, First-Served (FCFS)** CPU scheduling.

### Classes

**RegisterSet**
- Stores CPU register values (`XAR`, `XDI`, `XDO`, `PC`, `IR`, `EMIT`, `RR`, `PSW`, `R0-R7`).

**PCB**
- Represents a Process Control Block containing:
  - Process name
  - Priority
  - Arrival time
  - CPU burst time
  - Process state (`'r'`, `'e'`, `'t'`)
  - Register set

**OS**
- Simulation driver responsible for:
  - Process admission
  - Ready queue scheduling
  - CPU execution
  - Process termination

### Data Structures

**Process_Table**
- Fixed-size array of **50 PCBs** storing active processes.

**ReadyQ**
- FIFO queue implemented using `Queue<Integer>` to maintain FCFS scheduling order.

**TerminatedQ**
- Stores the PID of the most recently terminated process before clearing its slot.

**CPU**
- Stores the PID of the currently executing process.

### Simulation Behavior

- Process definitions are loaded from `processes2.txt` into an `ArrayList`.
- At each clock cycle (`global_time`), the system checks whether any processes arrive.
- If space exists in the process table:
  - A PCB is created
  - Inserted into the first available slot
  - Its PID is added to the Ready Queue.
- If the table is full:
  - The process arrival time is incremented, delaying its creation.
- When the CPU is idle:
  - The next process is dequeued from the Ready Queue.
- The CPU simulates execution by:
  - Incrementing `CPU_time`
  - Updating register values randomly.
- When the burst time is reached:
  - The process is terminated
  - The slot in the process table is cleared.

---

## Project 4: Memory Management with Variable Partition Allocation

- Introduced dynamic memory management into the simulator.

New PCB fields:
- `start_loc`
- `process_size`

New structures:

**MemoryWaitingQ**
- Holds processes waiting for available memory.

**Free_Partitions**
- Linked list representing available memory partitions.

Memory management functions:

- **Allocate()**
  - Assigns memory to processes using variable partition allocation.

- **Deallocate()**
  - Frees memory after process termination and updates the free partition list.

This project demonstrates how **memory constraints interact with process scheduling**.

---

## File Inputs

Each input file (`processes1.txt`, `processes2.txt`, `processes4.txt`) contains one line per process.

Format:

1. Process Name  
2. Priority  
3. Arrival Time  
4. CPU Burst Time  
5. Process Size (Project 4 only)  
6. Register values (`XAR`, `XDI`, `XDO`, `PC`, `IR`, `EMIT`, `RR`, `PSW`, `R0-R7`)

---

## Key Concepts Demonstrated

- Process Control Blocks
- Process Table Management
- First-Come First-Served CPU Scheduling
- Queue-based scheduling
- Memory partition allocation
- Resource deallocation on termination

---

## Possible Extensions

- Round Robin scheduling
- Priority scheduling
- CPU utilization metrics
- Paging or segmentation
- I/O interrupt simulation

---

## Author

Developed as part of **CS451/CS650: Design of Operating Systems** coursework.
