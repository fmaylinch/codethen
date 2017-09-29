# Thread examples

- [ThreadSimpleExample](ThreadSimpleExample.java) : Simple example where 3 threads are created and started
- **ThreadExamples** : Several ways of creating threads
- **ThreadPoolExample** : Creates a pool of threads that can be reused
- **ThreadExecutorResultExample** : Shows how to retrieve results from the tasks the threads perform
- **Synchronized example** : Example of synchronization between threads (typical producer/consumer scenario)


## Important facts about threads:

- When a program stats, one thread is created (the main thread).
- Each thread has its own call stack (local variables and calls) and program counter (indicates the current instruction).
- All the threads in a program share the heap (where the objects are stored), so they can collaborate if they use the same objects.
- A thread can start other threads.
- Each thread runs independently; the system decides when to execute each one and for how long (they are usually rotated depending on processor(s) availability).
- There are ways to synchronize threads (for example, one thread can wait for another to finish).
- In the `synchronized(x)` zones (that use the same object `x`) there can only be one thread running. If other threads want to enter, they will be kept waiting until the zone is free.
- If a thread calls `x.wait()` it pauses and frees all the `synchronized(x)` zones so another thread may enter. The thread that called `x.wait()` will wake up when another thread calls `x.notify()` although, according to the point before, the awaken thread won't be able to continue running until the `synchronized(x)` zone is free.
- `x.wait()`  and `x.notify()` must be called inside a `synchronized(x)` zone.
- The `synchronized(x)` zones should be as small as possible; usually just the code that needs to use `x` in an atomic way (i.e. with no interference of other threads in the middle). 


You can find more information in the official Java tutorial:
https://docs.oracle.com/javase/tutorial/essential/concurrency/

