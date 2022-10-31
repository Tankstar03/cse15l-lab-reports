# Lab Report 3
## Command: `grep`
Searches a file or files for the given string, prints matching lines.
### Switches
One interesting thing that can be prepended before `grep` are switches. Switches include options that allow your string keyword to ignore cases (upper and lower), show which line(s) the string was also found within the file, as well as inverting the search.

`-i`
![image](Screenshots\grep_switch-i.png)

The `-i` switch ignores the cases of the string you are searching with. Useful when the string you are searching for could be at the start of a sentence, thus this can eliminate having to deal with that capitalized letter.

`-c` & `-n`
![image](Screenshots\grep_switch-n.png)

`-c` counts the number lines the string appears in and `-n` shows the lines where the string appeared in the file. They both can be useful when you need to keep track the amount of times a string shows up in a file.

`-v`
![image](Screenshots\grep_switch-v-1.png)
![image](Screenshots\grep_switch-v-2.png)

The `-v` inverts your search and shows all lines where the string does not show up in a file. It is useful in the opposite way as grep is itself, finding all the lines where the specific string does not show up. It can also be seen that multiple swithces can be used in the same command line.

### File Name Search
`grep` can not only be used to search for strings in a file or files, but it can also search for strings in a filename or filenames.

Search Filename
![image](Screenshots\grep_filename.png)

Used to search for files with names that contain the string "002". Can be helpful when trying to find specific file names, filtering out all the files that do not contain the string in their name.

Search Filetype
![image](Screenshots\grep_filetype.png)

Used to search for files that have the same type as the string. This can be quite useful when you want to filter out specific types of files, the examples shows the command line filtering out any file that is not a txt file.

Search Folder
![image](Screenshots\find-government.png)
![image](Screenshots\grep_folder.png)

This time, `grep` is used to search for any file that is contained within any folders that contain the string "media". Like the previous examples, this is another way of filtering out unwanted files, but this time they are organized under separate folders.

### Anchors
`grep` also has the ability to add anchors before the desired string you would like to search up in a file.

Start of Word
![image](Screenshots\grep_anchor-word_start.png)

The command "\<a" means to find all lines that contains at least one word that begins with the letter "a". Useful in finding lines that contain words that begin with a string, filtering all that do not.

End of Word
![image](Screenshots\grep_anchor-word_end.png)

The command "e\>" means to find all lines that contains at least one word that ends with the letter "e". Useful in finding lines that contain words that end with a specific string.

End of Line
![image](Screenshots\grep_anchor-line_end.png)

The "$" anchor that follows the search string (in this case "e") means to find all lines that end with the specified string. Similar to the one above, it is quite handy in finding lines that end with a particular string. Note: "[[:cntrl:]]" is needed in the command in this case because `grep` is expecting an Unix line like ending. If the segment above is ommitted, the output will just be the entire text file, although all the lines that end with the searched string will be highlighted:
![image](Screenshots\grep_anchor-line_end-alt.png)

[Back to index](https://tankstar03.github.io/cse15l-lab-reports/)

[Back to github](https://github.com/Tankstar03/cse15l-lab-reports)