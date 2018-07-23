module Ejemplos where

cAdd :: Int -> Int -> Int
cAdd x y = x + y

add :: (Int, Int) -> Int
add (x,y) = x + y

squarepow :: Int -> Int
squarepow x = x * x

doubleHO :: (Int -> Int) -> Int -> Int
doubleHO f x = f (f x)

fourthpow :: Int -> Int
fourthpow = doubleHO squarepow
