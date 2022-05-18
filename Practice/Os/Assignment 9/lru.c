#include <stdio.h>
#include <stdlib.h>

int **frames, prs[100], n, p, page_faults = 0, counter = 0;

int is_present(int page)
{
    int i;
    for(i = 0; i < n; i++)
        if(frames[i][0] == page)
            return 1;
    return 0;
}

int min_count_index()
{
    int i, min_count = 1000000, index;
    for(i = 0; i < n; i++)
    {
        if(frames[i][1] < min_count)
        {
            min_count = frames[i][1];
            index = i;
        }
    }
    return index;
}

void printFrames()
{
    int i;
    for(i = 0; i < n; i++)
        printf("%d\t", frames[i][0]);
    printf("\n");
}




void lru()
{
    int i, j, index;
    for(i = 0; i < p; i++)
    {
        if(is_present(prs[i]))
        {
            for(j = 0; j < n; j++)
            {
                if(frames[j][0] == prs[i])
                    frames[j][1] = counter;
            }
        }
        else
        {
            index = min_count_index();
            frames[index][0] = prs[i];
            frames[index][1] = counter;

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

    frames = (int **)malloc(sizeof(int*) *n);
    for(i = 0; i < n; i++)
    {
        frames[i] = (int *)malloc(sizeof(int)*2);
        frames[i][0] = -1;
        frames[i][1] = -1;
    }

    lru();
    printf("page faults :%d", page_faults);

}