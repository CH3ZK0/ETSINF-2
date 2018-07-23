import qualified Circle
import qualified Triangle
main = do
putStrLn ("The area is " ++ show (Circle.area 2))
let other = (Triangle.area 4 5)
putStrLn ("Another area is " ++ show other)
