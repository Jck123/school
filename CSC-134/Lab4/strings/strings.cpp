//////////////////////////////////////////////////////////////////////////
// Filename: strings.cpp                                                //
// Date: March 17, 2020                                                 //
// Programmer: James Kelly                                              //
//                                                                      //
// Description:                                                         //
//      This program takes a file, 3 words, and searches the file       //
//      for those 3 words and also counts how many vowels are in        //
//      those searched words                                            //
//////////////////////////////////////////////////////////////////////////
#include <string>
#include <fstream>
#include <iostream>
using namespace std;

int wordSearch (string strWord, string &fileName)
{
    ifstream file;
    file.open(fileName);        //Opens file to be read
    string word;                //Word being searched
    string rawWord = "";        //Word being searched in uppercase
    string rawStrWord = "";     //Word to search in uppercase
    int matches = 0;
    while (file >> word)        //Checks each individual word in the file
    {
        for (char ch : word)
        {
            if (isalpha(ch)) { rawWord = rawWord + (char)toupper(ch); }             //Removes symbols and converts full string to uppercase
        }

        for (char ch : strWord) { rawStrWord = rawStrWord + (char)toupper(ch); }    //Converts full string to uppercase
        if (rawStrWord == rawWord) //Match!
        {
            matches++;
        }
        rawWord = "";       //Resets raw words
        rawStrWord = "";
    }
    return matches;
    file.close();           //Resets file
}

int vowelCount(string strWord)
{
    int vowelCount = 0;
    for (char ch : strWord)     //Bootleg for each loop
    {
        ch = toupper(ch);       //Converts each letter to check into uppercase
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
        {
            vowelCount++;
        }
    }
    return vowelCount;
}

int main()
{
    string word1;   //Words you can search
    string word2;
    string word3;
    string fileName;
    cout << "Enter the name of the file you wish to analyze: ";
    cin >> fileName;        //File opener
    cout << "Enter which words you would like to count with each word seperated by spaces.\nPick 3 words" << endl;
    cin >> word1 >> word2 >> word3;     //Grabs 3 words
    cout << "The word '" << word1 << "' was found " << wordSearch(word1, fileName) << " times and has " << vowelCount(word1) << " vowels." << endl; //Prints results
    cout << "The word '" << word2 << "' was found " << wordSearch(word2, fileName) << " times and has " << vowelCount(word2) << " vowels." << endl;
    cout << "The word '" << word3 << "' was found " << wordSearch(word3, fileName) << " times and has " << vowelCount(word3) << " vowels." << endl;
    cin >> fileName;
}