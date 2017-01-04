This program lets you analyze an image by predicting what number is down on the image.

My program is designed to work when the files are located in a specific way. The ”hidden-weights.txt”, “output-weights.txt”, and the “labels.txt” files need to be located in the same directory as the java file it self. 

The numbers need to be located in a folder named “numbers” (all small letters), which is located also in the same directory. There is no need to specify the directory when running the program, just write “java feedforward 0.png”. The program knows to look for the file in a folder named “numbers”.

The bonus program analyses the predictions of all the numbers and produces the accuracy of the program.

Instructions to run the program: 
java feedforward [name of file with the image that is located in the numbers folder]