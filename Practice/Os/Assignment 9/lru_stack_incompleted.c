#include <stdio.h>
#include <stdlib.h>

int *frames, prs[100], n, p, page_faults = 0, counter = 0;

struct node
{
    int data;
    struct node *next;
}*top = NULL,  *bottum = NULL;


int is_present(int page)
{
    int i;
    for(i = 0; i < n; i++)
        if(frames[i] == page)
            return 1;
    return 0;
}


void printFrames()
{
    int i;
    for(i = 0; i < n; i++)
        printf("%d\t", frames[i]);
    printf("\n");
}

void addToStack(int page)
{
    struct node *ptr;
    for(ptr = top; ptr != ; ptr = ptr->next)
        

}

void lru()
{
    int i, j, index;
    for(i = 0; i < p; i++)
    {
        if(is_present(prs[i]))
        {

        }
        else
        {
            index 
            frames[index] = prs[i];

            page_faults++;
        }
        printFrames();
        counter++;
    }
}

int main()
{
    int i;
    printf("Enter p");
    scanf("%d", &p);
    printf("Enter n");
    scanf("%d", &n);

    for(i = 0; i < p; i++)
        scanf("%d", &prs[i]);

    frames = (int *)malloc(sizeof(int) *n);

    lru();
    printf("page faults :%d", page_faults);

}