import Stack

toList :: (Stack a) -> [a]
toList x = if((isEmpty x) == False) then (top x):(toList ( pop x)) else []

fromList :: [a] -> (Stack a)
fromList [] = empty
fromList [x] = push x empty
fromList (x:xs) = push x (fromList xs)
