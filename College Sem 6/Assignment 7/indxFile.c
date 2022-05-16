#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
typedef struct IndxFile
{
	char name[10];
	int indx, length;
	int *indxb;
	struct IndxFile *next;
} file;
bool *bv;
int i, j, N, flag;
int static freeBlock = 0;
file *head = NULL, *cur = NULL, *new = NULL, *temp = NULL, *tail = NULL;

char *newFile();
char *deleteFile();
void printList();
int isPresent(char *name)
{
	cur = head;
	if (!cur)
		return 0;

	while (cur)
	{
		if (!strcasecmp(name, cur->name))
			return 1;
		cur = cur->next;
	}
	return 0;
}
void printList()
{
	cur = head;
	j = 1;
	if (!cur)
		return;
	printf("Here are files:\n");
	printf("File Name     Size\n");
	while (cur->next != NULL)
	{
		printf("%d) %s\t\t%d\n", j, cur->name, cur->length);
		cur = cur->next;
		++j;
	}
	printf("%d) %s\t\t%d\n", j, cur->name, cur->length);
}

int main(int argc, char const *argv[])
{
	head = NULL;
	int n, choice;
	printf("Entr the disk size:\n");
	scanf("%d", &n);
	N = n;
	freeBlock = N;
	bv = (bool *)malloc(sizeof(n));
	for (int i = 0; i < N; ++i)
	{
		bv[i] = 1;
	}
	do
	{
		printf("Free blocks are %d", freeBlock);
		printf("\n\t1)Bit vector\n\t2)Create file\n\t3)show Directory \n\t4)Delete File\n\t5)Exit\nEnter you choice->");
		scanf("%d", &choice);
		switch (choice)
		{
		case 1:
		{
			for (int i = 0; i < N; ++i)
			{
				printf("%d ", bv[i]);
			}
		}
		break;
		case 2:
		{
			printf("%s", newFile());
		}
		break;
		case 4:
			printf("%s", deleteFile());
			break;
		case 3:
			printList();
			break;
		case 5:
			exit(0);
		}
	} while (choice > 0 && choice < 6);
	return 0;
}

char *newFile()
{
	char name[10];
	int indx, tmpFreeBlock;
	printf("Enter file name->");
	scanf("%s", name);
	while (isPresent(name))
	{
		printf("File is already exists:");
		scanf("%s", name);
	}
	printf("Enter the file length->");
	scanf("%d", &j);
	/*for (i = 0; i < N; ++i)
	{
		if (freeBlock == j + 1) break;
		else if (bv[i] == 1) ++freeBlock;
	}*/
	// printf("%d %d %d\n",__LINE__,freeBlock,sizeof(file));
	// printf("Free blocks are=%d",freeBlock);
	if (freeBlock <= j)
		return "Couldn't allocate the memory!";
	// printf("%p",new);
	new = (file *)malloc(sizeof(file));
	// printf("%d",__LINE__);
	if (new == NULL)
		return "System err!!!";
	new->indxb = (int *)malloc(sizeof(j * sizeof(int)));
	strcpy(new->name, name);
	new->length = j;
	new->next = NULL;
	flag = 1;
	int k = -1;
	freeBlock = freeBlock - j - 1;
	j += 1;
	i = 0;
	while (j)
	{
		if (flag && bv[i] == 1)
		{
			indx = i, flag = 0;
			bv[i] = 0;
			--j;
		}
		else if (bv[i] == 1)
			bv[i] = 0, new->indxb[++k] = i, --j;
		++i;
	}
	new->indx = indx;
	if (!head)
	{
		head = new;
		tail = head;
		return "Successfully created the file";
	}
	tail->next = new;
	tail = tail->next;
	return "Successfully created the file";
}
char *deleteFile()
{
	char name[10];
	if (!head)
		return "First create files!";
	printf("Enter file name:");
	scanf("%s", name);
	if (!isPresent(name))
		return "File is not found!";
	cur = head;
	file *back = NULL;
	while (cur)
	{
		if (!strcasecmp(cur->name, name))
			break;
		back = cur;
		cur = cur->next;
	}
	// all info is in cur pointer
	freeBlock = freeBlock + cur->length + 1;
	bv[cur->indx] = 1;
	for (i = 0; i < cur->length; ++i)
	{
		bv[cur->indxb[i]] = 1;
	}
	if (back == NULL)
	{
		head = cur->next;
		return "File deleted Successfully!";
	}
	back->next = cur->next;
	return "File deleted Successfully!";
}
