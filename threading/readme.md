#Concurrency(Threding)

------------------------------------------------------------


## Process


> Process has a self contained execution environment including private set of basic resources and own memory space 


## Threads

> Thread is lightweight process. Thread exist within process. Thread shares the process resource like memory space and open files

> Thread creation strategies

1.  Instantiate 'Thread' each time to initiate asynchronous task
2.  Pass application tasks to 'executor'


#### Instantiate Thread


1.  Implement Runnable

> instantiate Thread: new Thread( <runnable object>).start()

2.  Extends Thread Class

> extends Thread class
> implement run() method
> instantiate the object and call start() on it


### Thread methods


1.  sleep(long millis) : Pausing the execution
2.  interrupted() : InterruptedException set the interrupt flag
3.  Thread currentThread()-  get current thread name
4.  t.join()  : wait current execution thread until  "t" thread finish
5.  yeild() :  hint to the scheduler that the current thread is willing to yeild

## Synchronization

> Thread communication done by sharing fields and object reference. It give problem of interference and memory consistency

1.  Thread interference: In "counter" example , counter value may be overridden (exclusive access)
2.  Memory Consistency : "happens-before" relationship , a value is visible to other thread
3.  synchronization type:  synchronized methods and synchronized statements


### Locks 


> intrinsic lock or monitor lock
> Every object has an intrinsic lock associated with it


#### Synchronized Methods
> When Thread call synchronize method it acquire lock on that method object and release on return , and for static method it acquire lock on "Class" object


#### Synchronized Statements
> synchronize statement need to specify object that provide the intrinsic lock
> this will help for fine-grained synchronization


#### Reentrant locks
>  Thread can acquire a lock that he already own.


### Atomic Access
> atomic action is one that happens all at once. it will happen or not happen. 
> "volatile" guarantee you the atomicity
>  volatile may not solve memory consistency problem 
>  volatile vs synchronization
>  volatile is the best option if possible to use over synchronization



## Deadlock, Starvation and livelock.

### Deadlock
> deadlock is the situation where 2 or more threading blocking forever, waiting for each other


 




 







 
 






