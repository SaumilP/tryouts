using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DynamicCSVReaderTest
{
    public class Order
    {
        public string address { get; set; }

        public int orderId { get; set; }

        public string orderName { get; set; }

        public string productName { get; set; }

        public int quantity { get; set; }

        public string supplierName { get; set; }
    }
}