module Exercicis where
  import Data.Char
  numCbetw2 :: Char -> Char -> Int
  numCbetw2 p s
                | (ord p) > (ord s) = abs ((ord p) - (ord s + 1))
                | (ord p) < (ord s) = abs ((ord p + 1) - (ord s))
                | otherwise = 0
  
  sumatori :: Int -> Int -> Int
  sumatori a b = if(a == b) then a
                  else a + sumatori (a+1) b
                
  max' :: Int -> Int -> Int
  max' a b = if(a > b) then a
                  else b
                  
  leadyear :: Int -> Bool
  leadyear a
              | mod a 400 == 0 = True
              | mod a 100 == 0 = False
              | otherwise = mod a 4 == 0
              
  daysAmonth :: Int -> Int -> Int
  daysAmonth m a
              | m < 8 && odd m = 31
              | m > 7 && even m = 31
              | m > 7 && odd m = 30
              | otherwise = if leadyear a then 29 else 28
              
  remainder :: Int -> Int -> Int
  remainder d q
              | d == q = 0
              | q > d = d
              | otherwise = remainder (d - q) q
              
  fact :: Int -> Int
  fact 0 = 1
  fact n = n * fact (n - 1)

  sumFact :: Int -> Int
  sumFact n 
            | n == 0 = 1
            | otherwise = fact(n) + sumFact(n-1)
