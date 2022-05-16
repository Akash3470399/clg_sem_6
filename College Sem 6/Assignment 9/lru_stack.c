#include <stdio.h>
#include <stdlib.h>

int *frames, p, n, prs[100], page_faults = 0, bottom = 0, next = 0;

struct node {
    int no;
    struct node *next;
}*front = NULL, *rear = NULL;

int is_present(int key)
{
    int i;
    for (i = 0; i < n; i++)
    {
        if (frames[i] == key)
            return 1;
    }
    return 0;
}


void printFrames()
{
    int i;
    for (i = 0; i < n; i++)
        printf("%2d ", frames[i]);    
    printf("\n");
}


void lru_stack()
{
    int i, j, index = 0;
    for (i = 0; i < p; i++)
    {
        if (is_present(prs[i]))
        {
            for()
        }
        else
        {
            if(top < n-1)
            {
                top++;
                frames[top] = prs[i];
                stack[top] = prs[i];
            }
            else
            {
                for(j = 0; j < n; j++)
                {
                    if(stack[top] == frames[j])
                        frames[j] = prs[i];
                }

                for(j = bottom ; j < top; j--)
                    stack[j] = stack[j -];

                stack[top] = prs[i];
            }

            page_faults++;
            next++; 
        }
        printFrames();
    }
}


int main()
{
    int i = 0;
    printf("Enter number of pages:");
    scanf("%d", &p);

    printf("Enter number of frames:");
    scanf("%d", &n);

    frames = (int *)malloc(sizeof(int ) * n);
    stack = (int *)malloc(sizeof(int ) * n);
    for (i = 0; i < n; i++)
    {
        frames[i] = -1;
        stack[i] = -1;
    }
    

    printf("Enter Page referance string:\n(separated by space):");
    i = 0;
    do
    {
        scanf("%d", &prs[i++]);
    } while (getchar() != '\n' && i < p);

    lru_stack();

    printf("\nTotal page faults :%d\n", page_faults);
    return 0;
}
