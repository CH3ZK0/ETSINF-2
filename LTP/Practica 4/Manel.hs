-- *****************************
-- Exercises 
-- Practice 4 of LTP
-- *****************************
import Data.Char
-------------------------------------------------------------------
-- WARNING:
-- 	ESTE FICHERO SE PROPORCIONA PARA FACILITAR
--	LA COPIA DE LINEAS DE CODIGO DE AQUI AL PROGRAMA DEL ALUMNO
--      ESTE FICHERO NO COMPILA
--	EL INTERPRETE DE HASKELL GENERA UN PARSE ERROR
--	SI SE EJECUTA :load codigoEnPdf_P4
-------------------------------------------------------------------

-- *** Section 3. Reduction Strategy ***

repeat' :: a -> [a]
repeat' x = xs where xs = x:xs

take' :: Int -> [a] -> [a]
take' _ [] = []
take' n (x:t) 
         | n<=0      = []
         | otherwise = x : take' (n - 1) t


-- *** Exercise 1 - Practice 4 *** 
--Definir una funció per a calcular el valor binari cor-
--responent a un nombre enter no negatiu x:
decBin :: Int -> [Int]
decBin x = if x < 2 then [x]
           else (x `mod` 2) : decBin (x `div` 2)

-- example:
-- decBin 4 ==> [0,0,1]

-- *** Exercise 2 - Practice 4 *** 

binDec :: [Int] -> Int
binDec (x:[]) = x
binDec (x:y)  = x + binDec y * 2

-- example:
-- binDec [0,1,1] ==> 6


-- *** Exercise 3 - Practice 4 *** 

divisors :: Int -> [Int]
divisors a = [x | x<-[1..a], a `mod` x == 0]

-- example: 
-- divisors 24 ==> [1,2,3,4,6,8,12,24]

-- *** Exercise 4 - Practice 4 *** 

member :: Int -> [Int] -> Bool
member x xs=  not (null [()| y <- xs, x == y] )

-- examples: 
-- member 1 [1,2,3,4,8,9] ==> True
-- member 0 [1,2,3,4,8,9] ==> False

-- *** Exercise 5 - Practice 4 *** 

isPrime :: Int -> Bool
isPrime a 
       |a == 1 = True
       |otherwise = (length [() | x<-[1..a], a `mod` x == 0]) == 2

primes :: Int -> [Int]
primes a = take a [x | x<-[1..], isPrime x]

-- examples: 
-- isPrime 2 ==> True
-- primes 5  ==> [1,2,3,5,7]

-- *** Exercise 6 - Practice 4 *** 

repeated :: Int -> [Int] -> Int
repeated x xs = length [()| y <- xs, x == y]

-- example: 
-- repeated 2 [1,2,3,2,4,2] ==> 3

-- *** Exercise 7 - Practice 4 *** 

concat' :: [[a]] -> [a]
concat' [] = []
concat' [x] = x
concat' (x:xs) = x ++ concat' xs

-- example: 
-- concat' [[1,2],[3,4],[8,9]] ==> [1,2,3,4,8,9]

-- *** Exercise 8 - Practice 4 *** 

selectEven :: [Int] -> [Int]
selectEven xs = [x | x<-xs, not(odd x)]

-- example: 
-- selectEven [1,2,4,5,8,9,10] ==> [2,4,8,10]

-- *** Exercise 9 - Practice 4 *** 

selectEvenPos :: [Int] -> [Int]
selectEvenPos [] = []
selectEvenPos [x] = [x]
selectEvenPos (x:y:xs) = x:selectEvenPos xs

-- example: 
-- selectEvenPos [1,2,4,5,8,9,10] ==> [1,4,8,10]

-- *** Exercise 10 - Practice 4 *** 

iSort :: [Int] -> [Int]
iSort [] = []
iSort [x] = [x]
iSort (x:xs) = ins x (iSort xs)


ins :: Int -> [Int] -> [Int]
ins x [] = [x]
ins x (y:xs) = if x < y then (x:y:xs)
               else y:ins x xs
-- example: 
-- iSort [4,9,1,3,6,8,7,0] ==> [0,1,3,4,6,7,8,9]
-- ins 5 [0,1,3,4,6,7,8,9] ==> [0,1,3,4,5,6,7,8,9]

-- *** Exercise 11 - Practice 4 *** 

doubleAll :: [Int] -> [Int]
doubleAll xs = [x + x | x <- xs]

-- example: 
-- doubleAll [1,2,4,5] ==> [2,4,8,10]

-- *** Exercise 12 - Practice 4 *** 

map' :: (a -> b) -> [a] -> [b]
map' f [] = []
map' f xs = [ f x | x <- xs]

filter' :: (a -> Bool) -> [a] -> [a]
filter' p [] = []
filter' p xs = [ x | x <- xs, p x ]

-- *** Exercise 13 - Practice 4 *** 

comp :: Int
comp = (sum . map (^2) . filter even) [1..10]


-- *** Section 6.1. Enumerations ***

data Color = Red | Green | Blue


-- *** Section 6.2. Renamed types ***

type Distance = Float
type Angle = Float
type Position = (Distance,Angle)
type Pairs a = (a,a)
type Coordinates = Pairs Distance

-- *** Exercise 14 - Practice 4 *** 

type Person = String
type Book = String
type Database = [(Person, Book)]

exampleBase :: Database
exampleBase = [("Alicia", "El nombre de la rosa"), 
               ("Juan", "La hija del canibal"), 
               ("Pepe", "Odesa"), 
               ("Alicia", "La ciudad de las bestias")]

obtain :: Database -> Person -> [Book]
obtain dBase thisPerson
 = [book | (person,book) <- dBase, person == thisPerson]


borrow :: Database -> Book -> Person -> Database
borrow db b p = [ (person, book) | (person,book) <- db, not(book == b && person == p) ]


return' :: Database -> (Person,Book) -> Database
return' db (p, b) = db ++ [(p, b)]


-- *** Section 6.3. Trees ***

--data TreeInt = Leaf Int | Branch TreeInt TreeInt
data TreeInt = Leaf1 Int | Branch1 TreeInt TreeInt

-- examples: 
-- let t1 = Leaf1 4
-- let t2 = Branch1 (Leaf1 5) (Leaf1 7) 


data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show

-- examples: 
-- let t3 = Leaf 4
-- let t4 = Branch (Leaf 5) (Leaf 7) 
-- let t5 = Leaf 'q'
-- let t6 = Branch (Leaf "patata") (Leaf "cebolla") 

-- *** Exercise 15 - Practice 4 *** 

numleaves :: (Tree a) -> Int
numleaves (Leaf x)     = 1
numleaves (Branch a b) = numleaves a + numleaves b

-- examples: 
-- numleaves (Leaf 3) ==> 1
-- numleaves (Branch (Leaf 6) (Leaf 8)) ==> 2

-- *** Exercise 16 - Practice 4 *** 

symmetric :: Tree a -> Tree a
symmetric (Leaf a) = Leaf a
symmetric (Branch a b) =  Branch (symmetric b) (symmetric a)

-- example: 
-- symmetric (Branch (Leaf 5) (Leaf 7))

-- *** Exercise 17 - Practice 4 *** 

-- *** Section 6.3. Binary trees ***

data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt deriving Show

--let treeB1 = Void
--let treeB2 = (Node 5) Void Void
--let treeB3 = (Node 5) 
 --            ((Node 3)(Node 1 Void Void)(Node 4 Void Void)) 
 --            ((Node 6) Void (Node 8 Void Void))

listToTree :: [a] -> Tree a
listToTree [x] = Leaf x
listToTree (x:xs) = Branch (Leaf x) (listToTree xs)


treeToList :: Tree a -> [a]
treeToList Leaf x = [x]
treeToList (Branch x y) = (treeToList x) ++ (treeToList y)

-- *** Exercise 18 - Practice 4 *** 

insTree :: Int -> BinTreeInt -> BinTreeInt
insTree x Void = (Node x) Void Void
insTree x (Node y a b) = if x <= y then (Node y) (insTree x a) b
                                    else (Node y) a (insTree x b)

-- example: 
-- insTree 6 (Node 3 (Node 2 Void Void) (Node 7 (Node 4 Void Void) (Node 9 Void Void)))
-- ==> Node 3 (Node 2 Void Void) (Node 7 (Node 4 Void (Node 6 Void Void)) (Node 9 Void Void))

-- *** Exercise 19 - Practice 4 *** 

creaTree :: [Int] -> BinTreeInt
creaTree [x] = insTree x Void
creaTree (x:xs) = insTree x (creaTree xs)

-- example: 
-- creaTree [3,2,4,1]
-- ==> Node 1 Void (Node 4 (Node 2 Void (Node 3 Void Void)) Void)
 
-- *** Exercise 20 - Practice 4 *** 

treeElem :: Int -> BinTreeInt -> Bool
treeElem x Void = False
treeElem x (Node y a b) = if x == y then True
                                    else treeElem x a || treeElem x b

-- examples: 
-- treeElem 9 (Node 3 (Node 2 Void Void) (Node 7 (Node 4 Void Void) (Node 9 Void Void)))
-- ==> True
-- treeElem 6 (Node 3 (Node 2 Void Void) (Node 7 (Node 4 Void Void) (Node 9 Void Void)))
-- ==> False


-- *** Exercise 21 - Practice 4 *** 

dupElem :: BinTreeInt -> BinTreeInt
dupElem Void = Void
dupElem (Node y a b) = ((Node (y*2)) (dupElem a) (dupElem b))

-- examples: 
-- dupElem treeB1 ==> Void
-- dupElem treeB2 ==> Node 10 Void Void
-- dupElem treeB3 ==> Node 10
--                    (Node 6 (Node 2 Void Void) (Node 8 Void Void))
--                    (Node 12 Void (Node 16 Void Void))


-- *** Exercise 22 - Practice 4 *** 

data Tree' a = Branch' a (Tree' a) (Tree' a) | Void' deriving Show

countProperty :: (a -> Bool) -> (Tree' a) -> Int
countProperty x Void' = 0
countProperty f (Branch' x a b)
                              |f x = 1 + countProperty f a + countProperty f b
                              |otherwise = countProperty f a + countProperty f b

-- examples: 
-- countProperty (>9) (Branch' 5 (Branch' 12 Void' Void') Void') ==> 1
-- countProperty (>0) (Branch' 5 (Branch' 12 Void' Void') Void') ==> 2

