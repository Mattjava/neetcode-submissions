class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<Integer>();

        int base = 0;

        while(base < matrix.length && base < matrix[base].length && matrix[base][base] != 0)
        {
            int x = base;
            int y = base;

            while(y < matrix[x].length - base && matrix[x][y] != -101) {
                list.add(matrix[x][y]);
                matrix[x][y++] = -101;
            }
            y--;
            x++;
            System.out.println(list);
            while(x < matrix.length - base && matrix[x][y] != -101) {
                list.add(matrix[x][y]);
                matrix[x++][y] = -101;
            }
            x--;
            y--;
            System.out.println(list);
            while(y > -1 + base && matrix[x][y] != -101) {
                list.add(matrix[x][y]);
                matrix[x][y--] = -101;
            }
            y++;
            x--;
            while(x > -1 + base && matrix[x][y] != -101) {
                list.add(matrix[x][y]);
                matrix[x--][y] = -101;
            }

            base++;
        }


        return list;
    }
}
