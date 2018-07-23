type Height = Float
type Width = Float
type Radius = Float
type Volume = Float
type Superficie = Float

data Rectangle  = Rectangle Height Width deriving(Eq, Show)
data Circle = Circle Radius deriving(Eq, Show)

class (Eq a, Show a) => Shape a where
   area :: a -> Float
   perimeter :: a -> Float

instance Shape Rectangle where
   area (Rectangle h w) = h * w
   perimeter (Rectangle h w) = 2*(w+h)

instance Shape Circle where
   area (Circle r) = pi * r**2
   perimeter (Circle r) = 2*pi*r


volumePrism :: (Shape a) => a -> Height -> Volume
volumePrism figura h = (area figura) * h

surfacePrism :: (Shape a) => a -> Height -> Superficie
surfacePrism figura h = (perimeter figura)+(h*2)
