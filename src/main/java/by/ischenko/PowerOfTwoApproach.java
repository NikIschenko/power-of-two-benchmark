package by.ischenko;

public enum PowerOfTwoApproach {
	CALC {
		@Override
		public boolean isPowerOfTwo(int n) {
			if (n == 0)
				return false;

			while (n != 1) {
				if (n % 2 != 0)
					return false;
				n = n / 2;
			}
			return true;
		}
	},
	BIT {
		@Override
		public boolean isPowerOfTwo(int n) {
			return (n > 0 && ((n & (n - 1)) == 0));
		}
	},
	INT_BIT_COUNT {
		@Override
		public boolean isPowerOfTwo(int n) {
			return Integer.bitCount(n)==1;
		}
	};

	public abstract boolean isPowerOfTwo(int n);
}
