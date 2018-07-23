instance (Show a) => Show (Stack a) where
--redefinir el metodo show per a stack
show EmptyStack = "|"
show (Stk x y) = (show x) ++ " <- " ++ (show y)
