1. Program takes three arguments. 
1.1 First one is the name of a file with names which are blacklisted (one name per line).
1.2 The second one is the name of a file with tokens which are the noise (one word per line). 
1.3 The third argument is the name to be validated against the blacklist. 

2. Program realizes two checking strategies. 
2.1 The first strategy tries to make exact matches of splitted tokens of the names. 
2.2 The second one tries to make partial matches of splitted tokens of the names. Partial matching realized using Levenshtein algorithm with hardcoded similarity percentage (70%).  
2.3 In case the first strategy detects entry, the second strategy will not be applied. Detected entry (blacklisted name from input file) will be sent to output. In case nothing is detected, nothing will be sent to output. 
2.4 Matching is case-insensitive
2.5 Non-word characters are considered as separators for tokenizing the names

3. Files should be placed to the same folder where the program has to be executed.

4. Example of file with blacklisted names: sanctions.txt:
Osama Bin Laden
Dzugashvilli Stalin
Vladimir Lenin

5. Example of file with noise: noise.txt:
the
a
is
to
bin

6. Examples of execution:
6.1 Example 1
> ..\Test1> java ee.jevgeniu.Main sanctions.txt noise.txt "vladimir is lenin"
Vladimir Lenin

6.2 Example 2
> ..\Test1> java ee.jevgeniu.Main sanctions.txt noise.txt "stalin dsugashvili"
Dzugashvilli Stalin

6.3 Example 3
> ..\Test1\out\production\Test1> java ee.jevgeniu.Main sanctions.txt noise.txt "stalin bin dsugashvili"
Dzugashvilli Stalin

6.4 Example 4
> ..\Test1\out\production\Test1> java ee.jevgeniu.Main sanctions.txt noise.txt "lenin vladmir"
Vladimir Lenin

6.5 Example 5
> ..\Test1\out\production\Test1> java ee.jevgeniu.Main sanctions.txt noise.txt "lunoi volod"
