#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int *bit_vector, n;
FILE *fp = NULL;

struct dir_entry
{
    char filename[20];
    int start_block, length;
    struct dir_entry *next;
}*front = NULL, *rear = NULL;

void create_bit_vector()
{
    int i;
    printf("Enter size of n:");
    scanf("%d", &n);

    bit_vector = (int *)malloc(sizeof(int) * n);
    for(i = 0; i < n; i ++)
        bit_vector[i] = 1;
}
            
            
void show_bit_vector()
{
    int i, empty_count = 0;
    printf("\nBit vector\n");
    for(i = 0; i < n; i++)
    {
        printf("[%d] ", bit_vector[i]);
        if(bit_vector[i] == 1)
            empty_count++;
    }
    printf("\nTotal blocks: %d", n);
    printf("\nFree blocks : %d\n", empty_count);
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

int check_empty_blocks(int len)
{
    int i, empty_count = 0;
    for(i = 0; i < n; i++)
    {
        if(bit_vector[i] == 1)
        {
            empty_count++;
            if(empty_count == len)
                return (i - (len - 1));
        }    
        else
            empty_count = 0;
    }

    return -1;
}

void allocate_blocks(int sb, int len)
{
    int i;
    for(i = sb; i < sb + len; i++)
        bit_vector[i] = 0;
}

void create_new_file()
{
    char fn[50];
    int len, sb; 
    struct dir_entry *n, *ptr;

    printf("Enter file name :");
    scanf("%s", fn);
    for(ptr = front; ptr != NULL; ptr = ptr->next)
    {
        if(strcmp(ptr->filename, fn) == 0)
        {
            printf("file %s already exists.\n", fn);
            return;
        }
    }

    printf("Enter blocks length :");
    scanf("%d", &len);

    if(check_empty_blocks(len) != -1)
    {
        sb = check_empty_blocks(len);
        n = (struct dir_entry *)malloc(sizeof(struct dir_entry));
        strcpy(n->filename, fn);
        n->length = len;
        n->start_block = sb;

        allocate_blocks(sb,len);
        sprintf(fn, "./files/%s", n->filename);
        fp = fopen(fn, "w");
        fclose(fp);
        addToDir(n);        
    }
    else
        printf("\nFree blocks not available.\n");
}

void show_dir()
{
    struct dir_entry *ptr;
    if(front == NULL)
    {
        printf("\nDirectory is empty.\n");
        return;
    }
    printf("\nDirectory\nfile name start block length\n");
    for(ptr = front; ptr != NULL; ptr = ptr->next)
        printf("%s\t%d\t%d\n", ptr->filename, ptr->start_block,ptr->length);
    printf("\n");
}

void delete_file()
{
    char fn[50];
    struct dir_entry *ptr, *parent = NULL;
    int i;
    printf("Enter file name to delete :");
    scanf("%s", fn);

    for(ptr = front; ptr != NULL; ptr = ptr->next)
    {
        if(strcmp(ptr->filename, fn) == 0)
        {
            sprintf(fn, "./files/%s", ptr->filename);
            remove(fn);

            for(i = ptr->start_block; i < ptr->start_block + ptr->length; i++)
                bit_vector[i] = 1;

            if(parent == NULL)
                front = front->next;
            else
                parent->next = ptr->next;

            free(ptr);
            break;
        }
        parent = ptr;
    }
}

int main()
{
    int choice;
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
            choice = 5;
            break;
        
        default:
            printf("Invalid operation.\n");
        }
    } while (choice != 5);
    
}