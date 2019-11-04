# SeeSawSimulator

## Design
I used two threads, one for increasing and one for decreasing.  They could both access the "critical section" at any time, but needed to acquire the appropriate semaphore in order to modify the height of either Wilma or Fred.  After one would increase, it would release the decreasing semaphore so that the other person could decrease. Upon decreasing, the decreasing thread releases the increasing semaphore so that it can be acquired again and the process can repeat.  This process was repeated until the height of one person reached 7 or the height of the other got as low as 1.  Then they would switch.  The whole thing repeats 10 times.

## Other Info
To test this yourself, simply run the "exec.sh" script and the results will be sent to output.txt
