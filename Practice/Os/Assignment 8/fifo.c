#include <stdio.h>
#include <stdlib.h>

int *frames, prs[100], n, p, next = 0, page_faults = 0;

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


void fifo()
{
    int i;
    for(i = 0; i < p; i++)
    {
        if(!is_present(prs[i]))
        {
            frames[next % n] = prs[i];
            next++;
            page_faults++;
        }
        printFrames();
    }
}



int main()
{
    int i;
    printf("Enter n:");
    scanf("%d", &n);
    printf("Enter p:");
    scanf("%d", &p);

    frames = (int *)malloc(sizeof(int));

    for(i = 0; i < p; i++)
        scanf("%d", &prs[i]);

    fifo();
    printf("page faults :%d", page_faults);
    return 0;
}