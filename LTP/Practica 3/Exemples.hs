module Nextchar where
	import Data.Char
	nextchar :: Char -> Char
	nextchar c = chr ((ord c) + 1)

module Factorial where
	fact :: Int -> Int
	fact 0 = 1
	fact n = n * fact (n - 1)

