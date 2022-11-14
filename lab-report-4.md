# Lab Report 4
## Part 1
Objective: Changing the `main` method to take a command-line argument. Solution:

`/" <enter> NNcWargs[1])); <escape> /FileH <enter> nnc$this.files; <escape> :wq <enter>`

Start with the vim editor open on `DocSearchServer.java`

![image](Screenshots\vim_start.png)

Typing in `/" <enter>` will move the cursor to the first instance of `"` in the file.

![image](Screenshots\vim_find_technical.png)

`NNcW` means find the 3rd instance of `/"` from bottom and then delete the next word and enter insert mode.

![image](Screenshots\vim_NNcW.png)
![image](Screenshots\vim_NNcW2.png)

Fill in the replaced word with `args[1]));` should correctly have Handler read a command-line argument now.

![image](Screenshots\vim_args[1].png)

Like above, `/FileH` should find the first instance of `FileH`, but since the cursor is near the bottom of the file, no further instances are found, so it gets looped back to the top.

![image](Screenshots\vim_fileH.png)

`nnc$` will find the 3rd instance from top and then delete anything between the cursor and the end of the line before entering insert mode.

![image](Screenshots\vim_nnc$.png)
![image](Screenshots\vim_nnc$2.png)

Fill in the replaced line with `this.files;` this way the file paths taken in as a command-line argument will be properly stored.

![image](Screenshots\vim_this.files.png)

Do not forget to then leave insert mode as well as save and exit with `:wq`.

![image](Screenshots\vim_save_and_exit.png)

---
## Part 2
### Visual Studio Code: 60.15 seconds
### Vim (Remote Desktop): 62.23 seconds

No major difficulties arose during either time trials.

1. At the moment, due to my unfamiliarity with Vim, I would prefer making all of my edits on the local desktop and then scp the changed files into the remote desktop. Possibly if I do become more fluent with using Vim and knowing all its feature shortcuts, I may find using Vim on the remote desktop to be the more efficient method.
2. If I am editing only a few files, then I might prefer to do all my work on the local desktop. However, if the task involves many files across many folders and workspaces, doing the edits on remote can be an advantage, since scp takes time and having to use cp to organize files on the remote desktop can be tedious.

[Back to index](https://tankstar03.github.io/cse15l-lab-reports/)

[Back to github](https://github.com/Tankstar03/cse15l-lab-reports)