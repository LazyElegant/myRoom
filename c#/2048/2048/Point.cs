using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2048
{
    class Point
    {
        public int x { get; set; }
        public int y { get; set; }

        public Point(int sx, int sy)
        {
            x = sx;
            y = sy;
        }
        public Point() { x = -1; y = -1; }
    }
}
