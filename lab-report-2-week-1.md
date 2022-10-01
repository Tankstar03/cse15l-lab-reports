# Lab Report: Week 1
This tutorial will cover how to log into a course-specific account on `ieng6`.
***
## Step 1: Installing Visual Studio Code
Go to the Visual Studio Code website [https://code.visualstudio.com/](https://code.visualstudio.com/) and follow the intructions on how to download and install the source code editor. Once complete, when you open up VS Code you should see something like this:
[VS Code startup screen](https://imgur.com/a/jMDhBpS)
## Step 2: Remotely Connecting
Enter the following into the VS Code terminal:
```
$ ssh cs15lfa22XX@ieng6.ucsd.edu
```
Replace the XX with your course-specific letters. Answer `yes` to the following message.
```
Are you sure you want to continue connecting (yes/no/[fingerprint])?
```
This will then prompt you to enter your password. If the password you entered is correct but you are unable to log in, [click here for tutorials to reset your password](https://docs.google.com/document/d/1hs7CyQeh-MdUfM9uv99i8tqfneos6Y8bDU0uhn1wqho/edit). Once you are logged in, you should see the following screen:
[image1](https://imgur.com/WYp3UjY)
[image2](https://imgur.com/psl0i01)
## Step 3: Trying Some Commands
Now try some of the following commands on both your local computer and the remote computer (the one after inputing your ssh username and password), the last command listed exits you from the remote computer:
```
cd
cd ~
ls
ls -a
pwd
mkdir
cp /home/linux/ieng6/cs15lfa22/public/hello.txt ~/
cat /home/linux/ieng6/cs15lfa22/public/hello.txt
exit
```
Here is a screenshot of some examples:
[examples](https://imgur.com/5NQpO9q)
## Step 4: Moving Files with `scp`
First, copy the following code into a new java file in VS Code:
```
class WhereAmI {
  public static void main(String[] args) {
    System.out.println(System.getProperty("os.name"));
    System.out.println(System.getProperty("user.name"));
    System.out.println(System.getProperty("user.home"));
    System.out.println(System.getProperty("user.dir"));
  }
}
```
Enter the following compile and run commands in the terminal on your **local computer:**
```
$ javac WhereAmI.java
$ java WhereAmI
```
Then enter the following into your terminal (replacing XX with your course-specifc letters of course):
```
$ scp WhereAmI.java cs15lfa22XX@ieng6.ucsd.edu:~/
```
This will prompt you to enter the same password you used for the ssh log in. Then log back into ieng6 with `ssh` and type `ls` into the terminal, you should then see the WhereAmI file in your home directory, thus now you can enter the same compile and run commands on the remote computer.
[expected result](https://imgur.com/xfKYEvT)
## Step 5: SSH Key Setup
In short, setting up an SSH Key will allow you to log in into `ieng6` without having to enter your password everytime. To set it up, enter `ssh-keygen` into the terminal on your local computer. Any subsequent prompts just hit enter for the default response. Then log back into `ieng6` and enter `mkdir .ssh` into the terminal, now log back out. Then enter the following into the terminal on your local computer (using your own username and path):
```
$ scp /Users/joe/.ssh/id_rsa.pub cs15lfa22@ieng6.ucsd.edu:~/.ssh/authorized_keys
```
You should now be able to log into your remote computer without having to enter your password:
[expected result](https://imgur.com/glqBFXk)
## Step 6: Remote Running Optimization
If you ever want your remote running experience to be smoother, the up arrow key is your best friend. The VS Code terminal saves all the previous commands you entered into it, so using the up arrow allows you to easily reuse commands without having to re-type them. Using semicolons to separate individual commands allows you to run multiple commands on a single line:
```
$ cp javac WhereAmI.java; java WhereAmI
```
Try to use the least amount of keyboard and mouse inputs (1 input counts as hitting a key or clicking the mouse) to make an edit to the `WhereAmI.java` file and then copying and running it on the remote computer.
[Here is a sample](https://imgur.com/sCNPqgO)
## Finish
That's it! You have now finished the tutorial on VS Code setup and ieng6 basics.