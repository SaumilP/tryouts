using System.Collections.Generic;
using System.Net;
using System.Web.Http;
using System.Web.Mvc;
using ZumoDemo.Models;

namespace ZumoDemo.Controllers
{
    public class ProductController : ApiController
    {
        private ZumoDemo.Models.IRepository<Product> _repo;

        public ProductController()
            : this(new ZumoRepository<Product>())
        { }

        public ProductController(IRepository<Product> repo)
        {
            _repo = repo;
        }
        public IEnumerable<Product> Get()
        {
            return _repo.GetAll();
        }
        public Product Get(int id)
        {
            return _repo.Get(id);
        }
        public void Post(Product product)
        {
            if (ModelState.IsValid)
                _repo.Add(product);
            else
                throw new HttpResponseException(HttpStatusCode.BadRequest);
        }
        public void Put(Product prod)
        {
            if (ModelState.IsValid)
                _repo.Update(prod);
            else
                throw new HttpResponseException(HttpStatusCode.BadRequest);
        }
        [System.Web.Mvc.HttpDelete]
        public void Delete(int id)
        {
            _repo.Delete(id);
        }
    }
}
