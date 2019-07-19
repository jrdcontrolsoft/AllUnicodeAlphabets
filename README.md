# All Unicode Alphabets

A GUI Java program to show **ALL** the characters (glyphs) of all the fonts on your system on one big grid, one font at a time.

(Well, not quite "all." Right now, it's just the Basic Multilingual Plane. That's most of them except for emoji.) 

## Grid

The [Basic Multilingual Plane](https://en.wikipedia.org/wiki/Plane_%28Unicode%29#Basic_Multilingual_Plane) (BMP) has 64K characters. Most Unicode grids are about 64 characters across for visibility, which makes for a **long** scroll down into the deeper blocks of characters. Instead, taking an idea from the [grid](http://unifoundry.com/pub/unifont/unifont-12.1.02/unifont-12.1.02.bmp) on [unifoundry.com](http://unifoundry.com/unifont/), this is a 256 x 256 grid. Yes, that's _tiny_ characters on a _giant_ grid, but at least it's square. It's much quicker to see which alphabet blocks are in that font at a glance. 

## Colors

Each of the various blocks in the BMP are colored. The colors are roughly based on the [chart](https://en.wikipedia.org/wiki/Plane_%28Unicode%29#/media/File:Roadmap_to_Unicode_BMP.svg) on Wikipedia, though modified for a lighter background under black characters.   

## Use

All the fonts on your system are in a ComboBox drop-down at the top, with the grid of all BMP characters below it. Just pick another font from the ComboBox, or just cycle through them with the arrow keys. You can see at a glance which of your fonts covers lots of Unicode and which are only the ASCII set. I don't think any desktop system comes with fonts that covers _all_ of Unicode. If you want a font that has them all (at least in the BMP), I suggest [Unifont](http://unifoundry.com/unifont/) from Unifoundary.


Tested only on Windows so far. No reason it shouldn't work on Mac & Linux, but untested by me.

UI: Swing. Java level: 5+.

License: Public Domain. No copyright. Don't want to deal with licenses. Copy away: you can do anything, anything at all with this code. Don't have to credit me one bit. (Of course that means if someone puts this in a product and makes lots of money, I get nothing at all. Oh well.)

