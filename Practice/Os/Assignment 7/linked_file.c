#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *bit_vector, n;
FILE *fp;

struct block
{
    int no;
    struct block *next;
}*b_front = NULL, *b_rear = NULL;

struct dir_entry
{
    char filename[20];
    int start_block, end_block, length;
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
    int i = 0, allocated = 0;
    struct block *newBlock, *ptr;
    while (allocated != file->length)   
    {
        if(bit_vector[i] == 1)
        {
            bit_vector[i] = 0;
            
            newBlock = (struct block *)malloc(sizeof(struct block));
            newBlock->no = i;

            if(b_front == NULL)
            {
                b_front = newBlock;
                b_rear = b_front;
            }
            else
            {
                b_rear->next = newBlock;
                b_rear = b_rear->next;
            }
            allocated++;
        }

        if(allocated == 1)
            file->start_block = i;
        else if(allocated == file->length)
            file->end_block = i;
        i++;
    }
    
}

void create_new_file()
{
    char fn[50];
    int len;
    struct dir_entry *n, *ptr;

    printf("Enter filename :");
    scanf("%s", fn);

    for(ptr = front; ptr != NULL;  ptr = ptr->next)
    {
        if(strcmp(ptr->filename, fn) == 0)
        {
            printf("\nfile '%s' already exists.\n", fn);
            return;
        }
    }

    printf("Enter blocks length :");
    scanf("%d", &len);

    if(len <= free_blocks())
    {
        n = (struct dir_entry *)malloc(sizeof(struct dir_entry));
        strcpy(n->filename, fn);
        n->length = len;
        allocate_blocks(n);
        addToDir(n);

        sprintf(fn, "./files/%s", n->filename);
        fp = fopen(fn, "w");
        fclose(fp);
    }
    else
        printf("\nFree blocks not available.\n");
}


void show_dir()
{
    struct dir_entry *ptr;
    printf("\nDirectory\nfile name start block end block length\n");
    for(ptr = front; ptr != NULL; ptr = ptr->next)
        printf("%s\t%d\t\t%d\t\t%d\n", ptr->filename, ptr->start_block, ptr->end_block, ptr->length);
    printf("\n");
}

int main()
{
    int i, choice;
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
        
        default:
            printf("\nInvalid operatin.\n");        
            break;
        }
    } while (choice != 5);
    

}