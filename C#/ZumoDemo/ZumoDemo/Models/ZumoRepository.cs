using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Http;
using Newtonsoft.Json;

namespace ZumoDemo.Models
{
    public class ZumoRepository<T> : IRepository<T> where T : Entity
    {
        private readonly string _address = "https://flipsrv.azure-mobile.net/tables/" + typeof(T).Name.ToString();
        private readonly HttpClient _client;
        private readonly string _key = "lVMyZdFVDtsjNFwaWFrsHWbXfwNkiA36";
        public ZumoRepository()
        {
            _client = new HttpClient();
            _client.BaseAddress = new Uri(_address);
            _client.DefaultRequestHeaders.Add("X-ZUMO-APPLICATION", _key);
            _client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            _client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/xml"));
            _client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/x-www-form-urlencoded"));
        }
    
        public void Add(T obj)
        {
            var responseTask = _client.SendAsJsonAsync<T>(HttpMethod.Post, string.Empty, obj);
            if (!responseTask.Result.IsSuccessStatusCode)
            {
                throw new HttpResponseException(responseTask.Result.StatusCode);
            }
        }

        public void Delete(int id)
        {
 	        var responseTask = _client.DeleteAsync(_client.BaseAddress+"/"+id.ToString());
            if(!responseTask.Result.IsSuccessStatusCode)
            {
                throw new HttpResponseException(responseTask.Result.StatusCode);
            }
        }

        public T Get(int id)
        {
 	        var resultTask = _client.GetStringAsync("?$filter=Id eq " + id);
            var obj = JsonConvert.DeserializeObject<IEnumerable<T>>(resultTask.Result);
            return obj != null ? obj.FirstOrDefault() : null;
        }

        public IEnumerable<T> GetAll()
        {
 	        var resutlTask = _client.GetStringAsync(string.Empty);
            var obj = JsonConvert.DeserializeObject<IEnumerable<T>>( resutlTask.Result );
            return obj;
        }

        public void Update(T entity)
        {
 	        var responseTask = _client.SendAsJsonAsync<T>(new HttpMethod("PATCH"), entity.id.ToString(), entity);
            if( !responseTask.Result.IsSuccessStatusCode )
            {
                throw new HttpResponseException(responseTask.Result.StatusCode);
            }
        }
    }
}