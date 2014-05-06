using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using CsvReader;

namespace DynamicCSVReaderTest
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            dynamic parser = new DynamicXmlParser(@"D:\Private\Code\Examples\C#\AdslUsageData\DynamicCSVReaderTest\Configurations\Orders.xml");

            Console.WriteLine(String.Format("Customer => \n\tName:{0} \n\tAddress: {1}\n"
                , parser.customer.name
                , parser.customer.address));

            Console.WriteLine(String.Format("Product => \n\tName:{0} \n\tQuantity:{1} \n\tSupplier:{2}"
                , parser.orderItem.product
                , parser.orderItem.quantity
                , parser.orderItem.supplier));

            ObjectBuilder builder = new ObjectBuilder();
            Object bld = builder.BuildObjectInstance(@"D:\Private\Code\Examples\C#\AdslUsageData\DynamicCSVReaderTest\Configurations\ClassOrder.xml");

            Console.ReadLine();
        }
    }
}