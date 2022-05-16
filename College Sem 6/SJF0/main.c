#include <stdio.h>

#include <stdlib.h>

float temp_bt = 0, current_at = 0;

struct node
{
    int pid;
    float at, bt, st, wt, ft;
    struct node *next, *pre;

} *jFront = NULL, *readyQueueFront = NULL, *readyQueueRear = NULL;

// constructor function to create a new node
struct node *newNode(int pid, float at, float bt)
{
    struct node *n = (struct node *)malloc(sizeof(struct node));
    n->pid = pid, n->at = at, n->bt = bt;
    n->st = 0, n->wt = 0, n->ft = 0;
    n->next = NULL, n->pre = NULL;
    return n;
}

void addTojobQueue(struct node *ptr)
{
    struct node *i, *parent = NULL;
    if (jFront == NULL)
        jFront = ptr;
    else
    {
        for (i = jFront; (i != NULL) && (i->at <= ptr->at); i = i->next)
            parent = i;

        if (parent == NULL)
        {
            if (jFront->at >= ptr->at)
            {
                jFront->pre = ptr;
                ptr->next = jFront;
                jFront = ptr;
            }
        }
        else
        {
            ptr->next = parent->next;
            if (parent->next != NULL)
                parent->next->pre = ptr;
            parent->next = ptr;
            ptr->pre = parent;
        }
    }
}

void printQueue(struct node *ptr)
{
    printf("Queue : ");
    while (ptr != NULL)
    {
        printf("p%d->", ptr->pid);
        ptr = ptr->next;
    }

    printf("\b\b\n");
}

void addToReadyQueue(struct node *ptr)
{
    if (readyQueueFront == NULL)
    {
        readyQueueFront = ptr;
        readyQueueFront->pre = NULL;
        readyQueueFront->next = NULL;
        readyQueueRear = readyQueueFront;
    }
    else
    {
        ptr->pre = readyQueueRear;
        readyQueueRear->next = ptr;
        readyQueueRear = readyQueueRear->next;
    }
}

void createReadyQueue()
{
    struct node *ptr = jFront, *min = NULL;
    temp_bt = ptr->bt;
    current_at = ptr->at;
    int i = 0;
 
    while(ptr != NULL)
    {
        while (ptr != NULL && ptr->at <= current_at)
        {
            if( ptr->bt <= temp_bt)
            {
                min = ptr;
                temp_bt = min->bt;
            }
            ptr = ptr->next;
        }

        if(min == NULL){
            min = jFront;
            current_at = min->at;
        }

        if(min == jFront)
            jFront = jFront->next;

        if(min->next != NULL)
            min->next->pre = min->pre;
        if(min->pre != NULL)
            min->pre->next = min->next;
        
        if(jFront != NULL){
            ptr = jFront;
            temp_bt = ptr->bt;
        }

        current_at += min->bt;

        addToReadyQueue(min);
        min = NULL;
    }
}





int main()
{
    int n, i;
    float at, bt;
    struct node *ptr;
    printf("Enter total no of process :");
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        printf("Enter arrival time & burst time saperated by a space :");
        scanf("%f %f", &at, &bt);
        ptr = newNode(i, at, bt);
        addTojobQueue(ptr);
    }

    printQueue(jFront);
    printf("\n");
    createReadyQueue();
    printQueue(readyQueueFront);
}