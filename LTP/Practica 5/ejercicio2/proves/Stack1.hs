module Stack (Stack, empty, push, pop, top, isEmpty) where
data Stack a = EmptyStack | Stk a (Stack a)-- deriving Show para 
--indicar que convertimos a string para poder mostar por pantalla
push x s = Stk x s
top (Stk x s) = x
pop (Stk _ s) = s
empty = EmptyStack
isEmpty EmptyStack = True
isEmpty (Stk x s) = False


