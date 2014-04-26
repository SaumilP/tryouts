using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ZumoDemo.Models
{
    public interface IRepository<T> where T: Entity
    {
        void Add(T entity);
        void Delete(int id);
        T Get(int id);
        IEnumerable<T> GetAll();
        void Update(T entity);
    }
}
