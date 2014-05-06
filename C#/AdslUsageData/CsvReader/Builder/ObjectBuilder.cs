using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using Microsoft.CSharp;

namespace CsvReader
{
    public class ObjectBuilder
    {
        public Object BuildObjectInstance(String xmlFile)
        {
            XDocument xDoc = XDocument.Load(xmlFile);
            var builder = new StringBuilder();
            var className = xDoc.Root.Name.LocalName;

            builder.AppendFormat(" using System; public class ").Append(className).Append(" { ");

            foreach (XElement n_ in xDoc.Descendants().Skip(1))
            {
                if (n_ != null)
                {
                    if (n_.Elements().Any())
                    {
                        //do nothing for now...
                    }
                    else
                    {
                        builder.AppendFormat("string _")
                               .Append(n_.Name.LocalName)
                               .Append(" = \"")
                               .Append(n_.Value).Append("\"; public string ")
                               .Append(n_.Name.LocalName).Append(" { get { return _")
                               .Append(n_.Name.LocalName).Append(" ; } set { _")
                               .Append(n_.Name.LocalName).Append(" = value; } } ");
                    }
                }
            }
            builder.Append(" } ");
            var compilerParams = new CompilerParameters();
            compilerParams.GenerateExecutable = false;
            compilerParams.GenerateInMemory = true;

            var cCompiler = CSharpCodeProvider.CreateProvider("CSharp");
            var compilerResult = cCompiler.CompileAssemblyFromSource(compilerParams, builder.ToString());

            if (compilerResult.Errors.HasErrors)
            {
                throw new Exception("An Error has occurred while building type");
            }
            return compilerResult.CompiledAssembly.CreateInstance(className, true);
        }
    }
}