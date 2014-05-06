using System;
using System.Collections.Generic;
using System.Dynamic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsvReader
{
    class DynamicCSV : DynamicObject
    {
        List<string> columns;
        StreamReader sr;
        string[] currentLine;

        public DynamicCSV(string file)
        {
            sr = new StreamReader(file);
            string columnLine = sr.ReadLine();

            columns = columnLine.Split(',').ToList<string>();
        }
        public bool Read()
        {
            if (sr.EndOfStream)
            {
                return false;
            }
            else
            {
                currentLine = sr.ReadLine().Split(',');
                return true;
            }
        }

        public override bool TryGetMember(GetMemberBinder binder, out object result)
        {
            int index = columns.FindIndex(col => col == binder.Name);

            if (index == -1)
            {
                result = null;
                return false;
            }
            result = this.currentLine[index];
            return true;
        }
    }
}
