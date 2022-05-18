#include <stdio.h>
#include <stdlib.h>

struct process
{
    int pid;
    float st, at, bt, wt, ft, tat;
    struct process *next;
}*front = NULL;

struct process *createNewProcess(int pid,float bt, float at)
{
    struct process *new_process = (struct process *)malloc(sizeof(struct process));
    new_process->pid = pid, new_process->bt = bt, new_process->at = at;
    new_process->next = NULL;
    return new_process;
}

void addToReadyQueue(struct process *new_process)
{
    struct process *parent = NULL, *ptr; 
    if(front == NULL)
        front = new_process;
    else
    {
        for(ptr = front; ptr != NULL && ptr->at <= new_process->at; ptr = ptr->next)
            parent = ptr;

        if(parent == NULL)
        {
            new_process->next = front;
            front = new_process;
        }
        else
        {
            new_process->next = parent->next;
            parent->next = new_process;
        }
    }
}

void printQueue()
{
    struct process *ptr;
    for(ptr = front; ptr != NULL; ptr = ptr->next)
        printf("p%d->", ptr->pid);
    printf("\b\b\n");
}

int main()
{
    int i,n;
    float at, bt;
    printf("Enter number of process :");
    scanf("%d", &n);
    for(i = 0; i < n; i++)
    {
        printf("Enter arrival time :");
        scanf("%f", &at);
    
        printf("Enter burst time :");
        scanf("%f", &bt);

        addToReadyQueue(createNewProcess(i, bt, at));
    }

    printQueue();
}