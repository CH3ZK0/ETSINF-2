type Height = Float
type Width = Float
type Radius = Float

data Shape = Rectangle Height Width | Circle Radius deriving (Eq, Show)

area :: Shape -> Float
area (Rectangle h w) = h * w
area (Circle r) = pi * r**2
