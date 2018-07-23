type Height = Float
type Width = Float
type Radius = Float

data Rectangle = Rectangle Height Width
data Circle = Circle Radius

class Shape a where
   area :: a -> Float

instance Shape Rectangle where
   area (Rectangle h w) = h * w

instance Shape Circle where
   area (Circle r) = pi * r**2

type Volume = Float
   volumePrism :: (Shape a) => a -> Height -> Volume
   volumePrism base height = (area base) * height
