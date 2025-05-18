
class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int colorTheGrid(int m, int n) {
        // For this problem, we'll use a column-by-column DP approach
        // since m is small (max 5) but n can be large (up to 1000)
        
        // First, let's generate all valid column configurations
        List<Integer> validMasks = new ArrayList<>();
        generateValidMasks(0, 0, m, 0, validMasks);
        
        int masksCount = validMasks.size();
        
        // Create a compatibility matrix between column configurations
        boolean[][] compatible = new boolean[masksCount][masksCount];
        for (int i = 0; i < masksCount; i++) {
            for (int j = 0; j < masksCount; j++) {
                compatible[i][j] = areCompatible(validMasks.get(i), validMasks.get(j), m);
            }
        }
        
        // Initialize DP array for the first column
        long[] dp = new long[masksCount];
        Arrays.fill(dp, 1);
        
        // Process each remaining column
        for (int col = 1; col < n; col++) {
            long[] nextDp = new long[masksCount];
            
            for (int currMask = 0; currMask < masksCount; currMask++) {
                for (int prevMask = 0; prevMask < masksCount; prevMask++) {
                    if (compatible[prevMask][currMask]) {
                        nextDp[currMask] = (nextDp[currMask] + dp[prevMask]) % MOD;
                    }
                }
            }
            
            dp = nextDp;
        }
        
        // Sum up all possibilities for the last column
        long result = 0;
        for (long count : dp) {
            result = (result + count) % MOD;
        }
        
        return (int) result;
    }
    
    // Generate all valid column configurations using backtracking
    private void generateValidMasks(int pos, int mask, int m, int prevColor, List<Integer> validMasks) {
        if (pos == m) {
            validMasks.add(mask);
            return;
        }
        
        // Try each color (0: red, 1: green, 2: blue)
        for (int color = 0; color < 3; color++) {
            // Skip if this color is the same as the previous cell's color
            if (pos > 0 && color == prevColor) {
                continue;
            }
            
            // Encode the color in the mask (we need 2 bits per color)
            int newMask = mask | (color << (pos * 2));
            generateValidMasks(pos + 1, newMask, m, color, validMasks);
        }
    }
    
    // Check if two column configurations are compatible (no adjacent cells have the same color)
    private boolean areCompatible(int mask1, int mask2, int m) {
        for (int i = 0; i < m; i++) {
            // Extract colors from the masks
            int color1 = (mask1 >> (i * 2)) & 3;
            int color2 = (mask2 >> (i * 2)) & 3;
            
            // If the colors are the same, the columns are not compatible
            if (color1 == color2) {
                return false;
            }
        }
        return true;
    }
}