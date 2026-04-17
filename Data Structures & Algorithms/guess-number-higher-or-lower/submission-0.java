/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while(left < right)
        {
            int chosenNumber = (int) ((right - left) / 2) + left;

            int result = guess(chosenNumber);

            if(result == 0)
                return chosenNumber;
            else if(result < 0)
                right = chosenNumber - 1;
            else
                left = chosenNumber + 1;
        }

        return (int) ((right - left) / 2) + left;
    }
}