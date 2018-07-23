module Stack (Stack, empty, push, pop, top, isEmpty) where
data Stack a = EmptyStack | Stk a (Stack a)
push x s = Stk x s
top (Stk x s) = x
pop (Stk _ s) = s
empty = EmptyStack
isEmpty EmptyStack = True
isEmpty (Stk x s) = False

instance (Eq a) => Eq (Stack a) where
  EmptyStack == EmptyStack = True
  Stk x EmptyStack == Stk y EmptyStack = x == y
  Stk x y == Stk a b = x == a && y == b
  _ == _ = False
