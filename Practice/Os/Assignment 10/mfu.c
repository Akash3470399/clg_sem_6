#include <stdio.h>
#include <stdlib.h>

int **frames, prs[100], n, p, page_faults = 0, counter = 1, max_default = 100000;

void printFrames()
{
    int i;
    for (i = 0; i < n; i++)
        printf("%d\t", frames[i][0]);
    printf("\n");
}

int is_present(int page)
{
    int i;
    for (i = 0; i < n; i++)
        if (frames[i][0] == page)
            return 1;
    return 0;
}

int max_freq_index()
{
    int i, j, max_feq = -1, index, last;
    for (i = 0; i < n; i++)
    {
        if (frames[i][1] > max_feq)
        {
            max_feq = frames[i][1];
            index = i;
        }
        else if (frames[i][1] == max_feq && max_feq != max_default)
        {
            last = frames[0][2];
            for (j = 0; j < n; j++)
            {
                if (frames[j][2] < last && frames[j][1] == max_feq)
                {
                    last = frames[j][2];
                    index = j;
                }
            }
        }
    }

    return index;
}

void mfu()
{
    int i, j, index;

    for (i = 0; i < p; i++)
    {
        if (is_present(prs[i]))
        {
            for (j = 0; j < n; j++)
            {
                if (frames[j][0] == prs[i])
                {
                    frames[j][1] += 1;
                    frames[j][2] = counter;
                }
            }
        }
        else
        {
            index = max_freq_index();
            frames[index][0] = prs[i];
            frames[index][1] = 1;
            frames[index][2] = counter;

            page_faults++;
        }
        counter++;
        printFrames();

    }
}

int main()
{
    int i;
    printf("Enter p");
    scanf("%d", &p);
    printf("Enter n");
    scanf("%d", &n);

    frames = (int **)malloc(sizeof(int *) * n);
    for (i = 0; i < n; i++)
    {
        frames[i] = (int *)malloc(sizeof(int) * 3);
        frames[i][0] = -1;          // page_number
        frames[i][1] = max_default; // freq
        frames[i][2] = -1;          // counter
    }

    for(i = 0; i  < p; i++)
        scanf("%d", &prs[i]);

    mfu();
    printf("Page_faults :%d", page_faults);
}