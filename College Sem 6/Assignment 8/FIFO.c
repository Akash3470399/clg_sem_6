#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *frames, p, n, next = 0, prs[100], page_faults = 0;

int is_present(int page);
void printFrames();
void fifo();

int main()
{
    int i = 0;
    printf("Enter number of pages:");
    scanf("%d", &p);

    printf("Enter number of frames:");
    scanf("%d", &n);

    frames = (int *)malloc(sizeof(int) * n);
    for (i = 0; i < n; i++)
        frames[i] = -1;

    printf("Enter Page referance string");
    for(i = 0; i < p;i++)
        scanf("%d", &prs[i]);
    system("clear");
    fifo();
    printf("\nTotal page faults :%d\n", page_faults);

    return 0;
}

void fifo()
{
    int i = 0;
    printf("\nFrames:\n");
    for (i = 0; i < p; i++)
    {
        if (!is_present(prs[i]))
        {
            frames[next % n] = prs[i];

            page_faults++;
            next++;
        }
        printFrames();
    }
}

int is_present(int page)
{
    int i;
    for (i = 0; i < n; i++)
    {
        if (frames[i] == page)
            return 1;
    }

    return 0;
}

void printFrames()
{
    int i;
    for (i = 0; i < n; i++)
        printf("%d ", frames[i]);
    printf("\n");
}