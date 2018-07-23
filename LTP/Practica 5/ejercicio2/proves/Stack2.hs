module Stack (Stack, empty, push, pop, top, isEmpty) where
data Stack a = Stk [a]
empty = Stk []
push x (Stk xs) = Stk (x:xs)
pop (Stk (x:xs)) = Stk xs
top (Stk (x:xs)) = x
isEmpty (Stk xs) = null xs
