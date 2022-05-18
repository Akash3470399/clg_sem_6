#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *bit_vector, n;
FILE *fp;

struct dir_entry
{
    char filename[20];
    int indexb[10], length;
    struct dir_entry *next;
}*front = NULL, *rear = NULL;

void create_bit_vector()
{
    int i;
    printf("Enter n:");
    scanf("%d", &n);
    bit_vector = (int *)malloc(sizeof(int) * n);

    for(i = 0; i < n; i++)
        bit_vector[i] = 1;
}

void show_bit_vector()
{
    int i, empty_count = 0;
    printf("\nBit vector :");
    for (int i = 0; i < n; i++)
    {
        printf("[%d] ", bit_vector[i]);
        if(bit_vector[i] == 1)
            empty_count++;
    }

    printf("\nTotal blocks :%d", n);
    printf("\nFree blocks :%d\n", empty_count);
    
}

int free_blocks()
{
    int i, empty_count = 0;
    for(i = 0; i < n; i++)
        if(bit_vector[i] == 1)
            empty_count++;
    return empty_count;
}

void addToDir(struct dir_entry *file)
{
    if(front == NULL)
    {
        front = file;
        rear = front;
    }
    else
    {
        rear->next = file;
        rear = rear->next;
    }
}

void allocate_blocks(struct dir_entry *file)
{
    int i = 0, allocated = 0, j = 0;

    while(allocated != file->length)
    {
        if(bit_vector[i] == 1)
        {
            bit_vector[i] = 0;
            file->indexb[j++] = i;
            allocated++;
        }
        i++;
    }
}

void create_new_file()
{
    char fn[50];
    int len, indexb[10];
    int i = 0;

    struct dir_entry *n,*ptr;

    printf("Enter file name:");
    scanf("%s", fn);

    for(ptr = front; ptr != NULL; ptr = ptr->next)
    {
        if(strcmp(ptr->filename, fn) == 0)
        {
            printf("\nFile %s already exists.\n", fn);
            return;
        }
    }

    printf("Enter length :");
    scanf("%d", &len);

    if(len <= free_blocks())
    {
        n = (struct dir_entry *)malloc(sizeof(struct dir_entry));
        strcpy(n->filename, fn);
        n->length = len;
        n->next = NULL;
        allocate_blocks(n);
        addToDir(n);

        fp =fopen(fn, "w");
    }
    else
        printf("\nFree blocks not available.\n");
}

void show_dir()
{
    struct dir_entry *ptr;
    printf("\nDirectory\nfile name start block end block length\n");
    for(ptr = front; ptr != NULL; ptr = ptr->next)
        printf("%s\t\t%d\n", ptr->filename, ptr->length);
    printf("\n");
}

void delete_file()
{
    char fn[20];
    struct dir_entry *ptr, *parent = NULL;
    int i, indx;
    printf("Enter file name :");
    scanf("%s", fn);

    for(ptr = front; ptr != NULL; ptr = ptr->next)
    {
        if(strcmp(ptr->filename, fn) == 0)
        {
            for(i = 0; i < ptr->length; i++)
            {
                indx = ptr->indexb[i];
                bit_vector[indx] = 1;
            }
            remove(fn);

            if(parent == NULL)
                front = front->next;
            else
                parent->next = ptr->next;

            free(ptr);
        }
        parent = ptr;
    }
}

int main()
{
    int i, choice;
    struct dir_entry *n;

    create_bit_vector();

    do
    {
        printf("\nEneter you choice \n\t1.Show bit vector\n\t2.Create new file.\n\t3.Show directory\n\t4.Delete file\n\t5.Exit\n>>>");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            show_bit_vector();
            break;
        case 2:
            create_new_file();
            break;
        case 3:
            show_dir();
            break;

        case 4:
            delete_file();
            break;

        case 5:
            break;
        
        default:
            printf("\nInvalid operatin.\n");        
            break;
        }
    } while (choice != 5);

}   