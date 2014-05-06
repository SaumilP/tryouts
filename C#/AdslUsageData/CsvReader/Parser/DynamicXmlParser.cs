using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace CsvReader
{
    public class DynamicXmlParser : DynamicObject
    {
        XElement element;

        public DynamicXmlParser(string filename)
        {
            element = XElement.Load(filename);
        }

        private DynamicXmlParser(XElement el)
        {
            element = el;
        }

        public override bool TryGetMember(GetMemberBinder binder, out object result)
        {
            if (element == null)
            {
                result = null;
                return false;
            }

            XElement sub = element.Elements().SingleOrDefault(x => x.Name.LocalName == binder.Name);
            
            if (sub == null)
            {
                result = null;
                return false;
            }
            else
            {
                result = new DynamicXmlParser(sub);
                return true;
            }
        }

        public override bool TryConvert(ConvertBinder binder, out object result)
        {
            try
            {
                result = Convert.ChangeType(element.Value, binder.ReturnType);
                return true;
            }
            catch { }
            return base.TryConvert(binder, out result);
        }

        public override string ToString()
        {
            return (element != null) ? element.Value : String.Empty;
        }

        public string this[string attr]
        {
            get
            {
                if (element == null)
                {
                    return String.Empty;
                }
                if (element.Attribute(attr) != null)
                {
                    return element.Attribute(attr).Value;
                }
                else
                {
                    return String.Empty;
                }
            }
        }
    }
}
