import Stack
main = do
putStrLn ((==) (pop (push 1 empty)))
putStrLn ((==) (push 10 (push 5 empty)))
