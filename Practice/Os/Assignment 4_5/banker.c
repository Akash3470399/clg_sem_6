#include <stdio.h>
#include <stdlib.h>

int *AVAILABLE, **ALLOCATION, **MAX, **NEED, n, m, *safe_seq, is_safe = 1;

void init_matrices()
{
    int i = 0;
    AVAILABLE = (int *)malloc(sizeof(int) * m);

    ALLOCATION = (int **)malloc(sizeof(int *) * n);
    for (i = 0; i < n; i++)
        ALLOCATION[i] = (int *)malloc(sizeof(int) * m);

    MAX = (int **)malloc(sizeof(int *) * n);
    for (i = 0; i < n; i++)
        MAX[i] = (int *)malloc(sizeof(int) * m);

    NEED = (int **)malloc(sizeof(int *) * n);
    for (i = 0; i < n; i++)
        NEED[i] = (int *)malloc(sizeof(int) * m);
}

void acceptAvailable()
{
    int i, res_count = 0;
    for (i = 0; i < m; i++)
    {
        do
        {
            printf("Enter AVAILABLE[%d] :", i);
            scanf("%d", &res_count);
            if (res_count < 0)
                printf("Invalid available entry.\n");
            else
                AVAILABLE[i] = res_count;
        } while (res_count < 0);
    }
}

void acceptMax()
{
    int i, j, max_req;
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < m; j++)
        {
            do
            {
                printf("Enter MAX[%d][%d]:", i, j);
                scanf("%d", &max_req);

                if(max_req < 0 || max_req > AVAILABLE[j])
                    printf("Invalid max entry.\n");
                else
                    MAX[i][j] = max_req;

            } while (max_req < 0 || max_req > AVAILABLE[j]);
            
        }
    }
}

void acceptAllocation()
{
    int i, j, allocation;
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < m; j++)
        {
            do
            {
                printf("Enter ALLOCATION[%d][%d]:", i, j);
                scanf("%d", &allocation);

                if(allocation < 0 || allocation > MAX[i][j])
                    printf("Invalid allocation entry.\n");
                else
                    ALLOCATION[i][j] = allocation;

            } while (allocation < 0 || allocation > AVAILABLE[j]);
            AVAILABLE[j] -= allocation;
        }

    }
}

void calculateNeed()
{
    int i, j;
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < m; j++)
            NEED[i][j] = MAX[i][j] - ALLOCATION[i][j];
    }
}

void printMatrix(int **mat)
{
    int i, j;

    for(i = 0; i < n; i++)
    {
        for(j = 0; j < m; j++)
            printf("%d\t", mat[i][j]);
        printf("\n");
    }
}

int cmp_tuple(int *a, int *b)
{
    int i;
    for(i = 0; i < m; i++)
        if(a[i] > b[i])
            return 0;
    return 1;
}

void safety_algo()
{
    int i, c = 0, j;
    int *work = (int *)malloc(sizeof(int) * m), *finished = (int *)malloc(sizeof(int) * n);
    safe_seq = (int *)malloc(sizeof(int) * n);

    for(i = 0; i < n; i++)
        finished[i] = 0;

    for(i = 0; i < m; i++)
        work[i] = AVAILABLE[i];

    for(i = 0; i < n*2; i++)
    {
        if(finished[i%n] == 0 && cmp_tuple(NEED[i%n], work))
        {
            finished[i%n] = 1;
            safe_seq[c++] = i%n;
            
            for(j = 0; j < m; j++)
                work[j] += ALLOCATION[i%n][j];
        }
    }

    for(i = 0; i < n; i++)
        if(finished[i] == 0)
            is_safe = 0;
}


int main()
{
    int i;
    printf("Enter n:");
    scanf("%d", &n);
    printf("Enter m:");
    scanf("%d", &m);

    init_matrices();
    acceptAvailable();
    acceptMax();
    acceptAllocation();
    calculateNeed();
    system("clear");

    printf("\nAllocation matrix :\n");
    printMatrix(ALLOCATION);

    printf("\nMax matrix :\n");
    printMatrix(MAX);

    printf("\nNeed matrix :\n");
    printMatrix(NEED);

    safety_algo();

    if(is_safe == 1)
    {
        printf("\nSystem is safe.\nSafe seq :");
        for(i = 0; i < n; i++)
            printf("%2d ", safe_seq[i]);
        printf("\n");
    }
    else
        printf("\nSystem is not safe.\n");

}