#include <stdio.h>
#include <stdlib.h>

struct process
{
    int pid;
    float st, at, bt, wt, ft, tat;
    struct process *next;
} *front = NULL;

int n, *finish_seq;

struct process *createNewProcess(int pid, float bt, float at)
{
    struct process *new_process = (struct process *)malloc(sizeof(struct process));
    new_process->pid = pid, new_process->bt = bt, new_process->at = at;
    new_process->ft = -1, new_process->st = -1, new_process->tat = -1;
    new_process->next = NULL;
    return new_process;
}

void accept_process(struct process *new_process)
{
    struct process *parent = NULL, *ptr;
    if (front == NULL)
        front = new_process;
    else
    {
        for (ptr = front; ptr != NULL && ptr->at <= new_process->at; ptr = ptr->next)
            parent = ptr;

        if (parent == NULL)
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

void printTable()
{
    struct process *ptr;
    printf("\nprocess\npid\tST\tWT\tFT\n");
    for (ptr = front; ptr != NULL; ptr = ptr->next)
        printf("%d  %f  %f %f\n", ptr->pid, ptr->st, ptr->wt, ptr->ft);
    printf("\b\b\n");
}

void sjf_algo()
{
    float current_at = front->at, min_bt = front->bt;
    int finished = 0;
    finish_seq = (int *)malloc(sizeof(int )*n);

    struct process *ptr = front, *min = NULL;

    while (finished != n)
    {
        while (ptr != NULL && ptr->at <= current_at)
        {
            if (ptr->bt <= min_bt && ptr->ft == -1)
            {
                min = ptr;
                min_bt = min->bt;
            }
            ptr = ptr->next;
        }

        if (min == NULL)
            current_at = ptr->at;
        else
        {
            min->st = current_at;
            min->wt = min->st - min->at;
            min->ft = min->st + min->bt;
            current_at += min->bt;
            min_bt = 10000;

            finish_seq[finished] = min->pid;

            finished++;
            min = NULL;

        }
        ptr = front;
    }
}

struct process *get_process(int pid)
{
        struct process *ptr = front;
        for(ptr = front; ptr != NULL;ptr = ptr->next)
            if(ptr->pid == pid)
                return ptr;
}

void printChart()
{
    int i;
    float j = 0;
    struct process *cp = NULL, *np = NULL;
    printf("\n------------------------------------------------------------------------------\n");
    for(i = 0; i < n; i++)
    {
        cp = get_process(finish_seq[i]);

        for(j = 0; j <= cp->bt; j += 1)
            printf(" ");
        
        printf("p%d", cp->pid);
        
        for(j = 0; j <= cp->bt; j += 1)
            printf(" ");

        printf("|");
        if(i != n - 1)
        {
            np = get_process(finish_seq[i+1]);
            if(cp->ft != np->st)
            {
                for(j = 0.25; j <= np->st - cp->ft; j += 0.25)
                  printf("*");
                printf("|");
            }   
        }
    }
    printf("\n------------------------------------------------------------------------------\n");
}

int main()
{
    int i;
    float at, bt;
    printf("Enter number of process :");
    scanf("%d", &n);
    for (i = 0; i < n; i++)
    {
        printf("Enter arrival time :");
        scanf("%f", &at);

        printf("Enter burst time :");
        scanf("%f", &bt);

        accept_process(createNewProcess(i, bt, at));
    }
    sjf_algo();
    printTable();
    printChart();
}